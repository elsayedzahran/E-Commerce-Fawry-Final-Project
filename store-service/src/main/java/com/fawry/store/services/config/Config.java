package com.fawry.store.services.config;

import com.fawry.store.services.mapper.InventoryMapper;
import com.fawry.store.services.mapper.StockHistoryMapper;
import com.fawry.store.services.mapper.WarehouseMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {InventoryMapper.class  , StockHistoryMapper.class , WarehouseMapper.class})
public class Config {
}
