package com.hq.acdm.dao.index;

import com.hq.acdm.model.index.VSequenceDepartureFetchrows;

import java.util.List;

public interface VSequenceDepartureFetchrowsMapper {
    int insert(VSequenceDepartureFetchrows record);

    int insertSelective(VSequenceDepartureFetchrows record);

    List<VSequenceDepartureFetchrows> getRecord();
}