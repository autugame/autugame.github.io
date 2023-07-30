package com.qfedu.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    //Transfer in.
    public void transferIn(@Param("inName") String inName, @Param("money") double money);

    //Transfer out.
    public void transferOut(@Param("outName") String outName, @Param("money") double money);
}
