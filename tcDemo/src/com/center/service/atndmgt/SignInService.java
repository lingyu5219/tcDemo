
/**
* Project Name:trainingCenter
* File Name:SignInService.java
* Package Name:com.center.service.atndMgt
* Date:2016年12月23日下午1:57:53
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.atndmgt;

import com.center.po.atndmgt.SignIn;

/**
* ClassName:SignInService <br/>
* Function: TODO ADD 签到. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午1:57:53 <br/>
* @author donghao
* @version
* @see
*/
public interface SignInService {
	/**
	 * 
	* signInSTU:(签到／签退). <br/>
	* @author donghao
	* @param signIn
	* @throws Exception
	 */
	public void addSignIn(SignIn signIn) throws Exception;
}

