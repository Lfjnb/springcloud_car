package com.jk.dao;

import com.jk.pojo.CarBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecordDao {

    @Select("SELECT\n" +
            "\t\tcar.id,\n" +
            "\t\tbrand.brandName as brandName,\n" +
            "\t\tseries.seriesName as seriesName,\n" +
            "\t\tcar.price,\n" +
            "\t\tdic.text as carAgeName,\n" +
            "\t\tcar.gearbox,\n" +
            "\t\tdic2.text as carModelName,\n" +
            "\t\tdic3.text as mileageName,\n" +
            "\t\tdic4.text as carCerNmae,\n" +
            "\t\tdic5.text as carSeatName,\n" +
            "\t\tdic6.text as carFuelName,\n" +
            "\t\tdic7.text as colorName,\n" +
            "\t\tcar.drive,\n" +
            "\t\tdic8.text as nationName,\n" +
            "\t\tdic9.text as elseName,\n" +
            "\t\town.ownerName as ownerName,\n" +
            "\t\tstore.storName as storeName,\n" +
            "\t\tarea.area as areaName,\n" +
            "\t\tcar.carLicense,\n" +
            "\t\timg.imgurl,\n" +
            "\t\tcar.carName\n" +
            "\tFROM\n" +
            "\t\tt_car AS car\n" +
            "\t\tLEFT JOIN t_brand AS brand ON car.brandId = brand.id\n" +
            "\t\tLEFT JOIN t_series AS series ON car.series = series.id\n" +
            "\t\tLEFT JOIN t_dictionary AS dic ON car.carAgeId = dic.codeid\n" +
            "\t\tLEFT JOIN t_dictionary AS dic2 ON car.carModel = dic2.codeid\n" +
            "\t\tLEFT JOIN t_dictionary AS dic3 ON car.mileageId = dic3.codeid\n" +
            "\t\tLEFT JOIN t_dictionary AS dic4 ON car.carCerId = dic4.codeid\n" +
            "\t\tLEFT JOIN t_dictionary AS dic5 ON car.carSeat = dic5.codeid\n" +
            "\t\tLEFT JOIN t_dictionary AS dic6 ON car.carFuel = dic6.codeid\n" +
            "\t\tLEFT JOIN t_dictionary AS dic7 ON car.color = dic7.codeid\n" +
            "\t\tLEFT JOIN t_dictionary AS dic8 ON car.nationId = dic8.codeid\n" +
            "\t\tLEFT JOIN t_dictionary AS dic9 ON car.elseId = dic9.codeid\n" +
            "\t\tLEFT JOIN t_owner AS own ON car.ownerId = own.id\n" +
            "\t\tLEFT JOIN t_store AS store ON car.storeId = store.id\n" +
            "\t\tLEFT JOIN t_area AS area ON car.areaId = area.id\n" +
            "\t\tLEFT JOIN t_imgs as img ON img.id = (\n" +
            "\t  SELECT MIN(s.id) FROM t_imgs s LEFT JOIN t_car c on s.carid=c.id)"+
            "where  car.id = #{value}")
    List<CarBean> saveRecord(Integer carid);
}
