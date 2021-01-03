package com.frxs.kangaroo.platform.frxskangaroodal.mapper;

import com.frxs.kangaroo.platform.frxskangaroo.common.dto.TagMainDto;
import com.frxs.kangaroo.platform.frxskangaroo.common.entity.TagMain;
import com.frxs.kangaroo.platform.frxskangaroo.common.wrapper.PageWrapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMainMapper {
    int deleteByPrimaryKey(Long id);

	@Options(useGeneratedKeys = true,keyProperty = "id", keyColumn = "id")
    int insert(TagMain record);

    int insertSelective(TagMain record);

    TagMain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TagMain record);

    int updateByPrimaryKey(TagMain record);

	List<TagMainDto> getList(@Param("pageWrapper") PageWrapper<TagMainDto> pageWrapper);
}