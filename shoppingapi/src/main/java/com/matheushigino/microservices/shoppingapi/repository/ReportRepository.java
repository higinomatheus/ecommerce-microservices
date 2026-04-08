package com.matheushigino.microservices.shoppingapi.repository;

import com.matheushigino.microservices.shoppingapi.dto.ShopReportDTO;
import com.matheushigino.microservices.shoppingapi.model.Shop;

import java.time.LocalDate;
import java.util.List;

public interface ReportRepository {
    public List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo);
    public ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim);
}
