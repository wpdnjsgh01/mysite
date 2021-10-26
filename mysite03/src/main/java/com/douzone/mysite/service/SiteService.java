package com.douzone.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.SiteRepository;
import com.douzone.mysite.vo.SiteVo;

@Service
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;
	
	public SiteVo getSite() {
		return getSite(false);
	}

	public SiteVo getSite(Boolean digest) {
		return siteRepository.find(digest);
	}
}
