package com.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface SourceDestMapper {
    Destination sourceToDestination(Source source);
    Source destinationToSource(Destination destination);


}
