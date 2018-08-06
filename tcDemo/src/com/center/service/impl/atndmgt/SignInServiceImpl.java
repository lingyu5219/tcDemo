
/**
* Project Name:trainingCenter
* File Name:SignInServiceImpl.java
* Package Name:com.center.service.impl.atndmgt
* Date:2016年12月26日下午12:43:28
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.impl.atndmgt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.atndmgt.SignInMapper;
import com.center.po.atndmgt.SignIn;
import com.center.service.atndmgt.SignInService;

/**
* ClassName:SignInServiceImpl <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月26日 下午12:43:28 <br/>
* @author donghao
* @version
* @see
*/
@Service
public class SignInServiceImpl implements SignInService {
	@Autowired
	private SignInMapper signInMapper;
	
	@Override
	public void addSignIn(SignIn signIn) throws Exception {
		signInMapper.addSignIn(signIn);
	}

}

