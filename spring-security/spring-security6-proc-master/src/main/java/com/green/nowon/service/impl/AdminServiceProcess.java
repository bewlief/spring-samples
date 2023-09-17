package com.green.nowon.service.impl;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.green.nowon.domain.dto.ItemImgSaveDTO;
import com.green.nowon.domain.dto.ItemListDTO;
import com.green.nowon.domain.dto.ItemSaveDTO;
import com.green.nowon.domain.entity.CategoryEntityRepository;
import com.green.nowon.domain.entity.ItemEntity;
import com.green.nowon.domain.entity.ItemEntityRepository;
import com.green.nowon.domain.entity.ItemImageEntity;
import com.green.nowon.domain.entity.ItemImageEntityRepository;
import com.green.nowon.service.AdminService;
import com.green.nowon.utils.FileUploadUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminServiceProcess implements AdminService {
	
	//private final FileUploadUtil fileUpload;
	
	private final AmazonS3Client s3Client;
	
	@Value("${cloud.aws.s3.bucket.temp}")
	private String TEMP_PATH;

	@Value("${cloud.aws.s3.bucket.upload}")
	private String UPLOAD_PATH;
	
	@Value("${cloud.aws.s3.bucket}")
	private String BUCKET;
	
	private final ItemEntityRepository itemRepo;
	
	private final ItemImageEntityRepository itemImgRepo;
	
	private final CategoryEntityRepository cateRepo;

	@Override
	public Map<String, String> tempUpload(MultipartFile tempImg) {
		//s3Upload는 static 메소드이므로 객체 필요 없음
		return FileUploadUtil.s3Upload(s3Client, BUCKET, TEMP_PATH ,tempImg);
		//return FileUploadUtil.classPathUpload("/images/upload/temp/", tempImg); //기존 파일 업로드 방식
	}

	//상품, 이미지 저장(순서대로)
	@Override
	public void saveProcess(ItemSaveDTO dto) {
		
		//아이템 저장: fk로 가져가기 위해 변수에 저장
		ItemEntity item = itemRepo.save(dto.toItemEntity());
		
		//이미지는 현재 temp에서 src 폴더로 이동
		String uploadKey = UPLOAD_PATH + dto.getNewName();
		String url = FileUploadUtil.s3TempToSrc(s3Client, BUCKET, dto.getBucketKey(), uploadKey);
		
		//fk로 사용하기 위해 Itementity 가져감
		itemImgRepo.save(ItemImageEntity.builder()
				.isDef(true)
				.isList(true)
				.url(url)
				.orgName(dto.getOrgName())
				.newName(dto.getNewName())
				.bucketKey(uploadKey)
				.item(item) //fk
				.build());
		
	}
	
	//이미지 여러개 저장하기
	@Override
	public void saveProcess(ItemSaveDTO itemDto, ItemImgSaveDTO imgDto, Long categoryNo) {
		
		ItemEntity item = itemRepo.save(itemDto.toItemEntity()
				.addCategory(cateRepo.findById(categoryNo).orElseThrow())); //categoryNo 삽입
		
		String[] bucketKeys = imgDto.getBucketKey();
		String[] orgNames = imgDto.getOrgName();
		String[] newNames = imgDto.getNewName();
		
		for(int i=0; i<bucketKeys.length; i++) {
			if(bucketKeys[i]==null || bucketKeys[i]=="") continue;
			
			String orgName = orgNames[i];
			String newName = newNames[i];
			String uploadKey = UPLOAD_PATH + newNames[i];
			String url = FileUploadUtil.s3TempToSrc(s3Client, BUCKET, bucketKeys[i], uploadKey);
			
			if(i==0) {
				itemImgRepo.save(ItemImageEntity.builder()
						.bucketKey(bucketKeys[i])
						.isDef(true) //대표 이미지
						.isList(true)
						.url(url)
						.orgName(orgName)
						.newName(newName)
						.item(item)
						.build()
						);
			} else {
				itemImgRepo.save(ItemImageEntity.builder()
						.bucketKey(bucketKeys[i])
						.isDef(false) //생략 가능: 기본값=false
						.isList(true)
						.url(url)
						.orgName(orgName)
						.newName(newName)
						.item(item)
						.build()
						);
			}
		}
		
		
	}
	

	@Override
	public void findAllProcess(Model model) {
		model.addAttribute("list", itemRepo.findAll().stream()
				/*
				.map(item -> {
					ItemListDTO dto = new ItemListDTO(item);
					dto.defImg(itemImgRepo.findByItemAndIsListAndIsDef(item, true, true).get());
					return dto;})
				 */
				.map(item -> new ItemListDTO(item).defImg(itemImgRepo.findByItemAndIsListAndIsDef(item, true, true)
						.orElse(ItemImageEntity.builder()
								.url("/images/common/no-image.jpg") //이미지가 없을 때 기본 이미지로 대체
								.build()))) //위 식을 줄여서 씀: get() 대신 orElse() 활용 >> get은 무조건 존재할 때 가져오기
				.collect(Collectors.toList())
				);
		
	}

	
	
	
	//자바 8 이전 방식
	/*
	@Override
	public void findAllProcess(Model model) {
		//아이템 목록 가져오기
		List<ItemEntity> itemResult = itemRepo.findAll();
		
		//현재 itemImageEntity에서 manyToOne으로 연결되어있기 때문에 ItemEntity에서는 ItemImageEntity에 접근 불가
		//ItemImageEntity에서 조건절을 통해 이미지 가져오기
		List<ItemListDTO> result = new ArrayList<>();
		
		for(ItemEntity item : itemResult) {
			
			ItemListDTO itemList = new ItemListDTO(item);
			
			ItemImageEntity defImg = itemImgRepo.findByItemAndIsListAndIsDef(item, true, true).get();
			
			itemList.defImg(defImg);
			
			result.add(itemList);
		}
		
		model.addAttribute("list", result);
		
	}
	*/
	
}
