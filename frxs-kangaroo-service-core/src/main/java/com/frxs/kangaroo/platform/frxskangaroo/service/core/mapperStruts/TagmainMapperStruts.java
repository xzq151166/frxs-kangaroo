package com.frxs.kangaroo.platform.frxskangaroo.service.core.mapperStruts;

import com.frxs.kangaroo.platform.frxskangaroo.common.dto.TagMainDto;
import com.frxs.kangaroo.platform.frxskangaroo.common.entity.TagMain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagmainMapperStruts {
    TagmainMapperStruts MAPPER = Mappers.getMapper(TagmainMapperStruts.class);

	TagMain TagMainDto2TagMain(TagMainDto recordDto);

	TagMainDto TagMain2TagMainDto(TagMain record);
}
