/**
 * 
 */
package com.mhy.mapper;

import org.apache.ibatis.annotations.Select;

import com.mhy.model.Student;

/**
 * @author mahaiyuan
 *
 */
public interface StudentMapper {

	public Student getStudent2(int id);
	
	@Select("SELECT id, name, gender FROM Student WHERE id = #{id}")
	public Student getStudent3(int id);
}
