package com.center.po.perfmgt;

import com.center.po.query.QueryCondition;

/**
 * 
* ClassName: Score <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON(可选). <br/>
* date: 2017年1月4日 下午9:42:00 <br/>
*
* @author 钱兆瑞
* @version
 */

public class Score extends QueryCondition{
    private Integer scoreId;

    private Integer scorestudentId;

    private Integer scorecourseId;

    private Float score;

    private String createTime;

    private Integer createBy;

    private String remark;

    
    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
	

	public Integer getScorecourseId() {
		
			return scorecourseId;
	}

	public void setScorecourseId(Integer scorecourseId) {
		
			this.scorecourseId = scorecourseId;
	}

	public Integer getScorestudentId() {
		
			return scorestudentId;
	}

	public void setScorestudentId(Integer scorestudentId) {
		
			this.scorestudentId = scorestudentId;
	}

	public Integer getScoreId() {
		
			return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		
			this.scoreId = scoreId;
	}

	public String getCreateTime() {
		
			return createTime;
	}

	public void setCreateTime(String createTime) {
		
			this.createTime = createTime;
	}

	public Integer getCreateBy() {
		
			return createBy;
	}

	public void setCreateBy(Integer createBy) {
		
			this.createBy = createBy;
	}
}