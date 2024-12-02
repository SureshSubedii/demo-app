package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SourceDestMapper {
    SourceDestMapper   MAPPER = Mappers.getMapper(SourceDestMapper.class);
    Destination sourceToDestination(Source source);
    Source destinationToSource(Destination destination);

}
