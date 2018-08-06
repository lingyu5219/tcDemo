
/**
* Project Name:trainingCenter
* File Name:SignInMapper.java
* Package Name:com.center.mapper.atndMgt
* Date:2016年12月23日下午1:41:21
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.mapper.atndmgt;

import com.center.po.atndmgt.SignIn;

/**
* ClassName:SignInMapper <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午1:41:21 <br/>
* @author donghao
* @version
* @see
*/
public interface SignInMapper {
	/**
	 * 
	* signInSTU:(签到签退). <br/>
	* TODO 无要求
	*
	* @author donghao
	* @param signIn
	* @throws Exception
	 */
	public void addSignIn(SignIn signIn) throws Exception;
}

