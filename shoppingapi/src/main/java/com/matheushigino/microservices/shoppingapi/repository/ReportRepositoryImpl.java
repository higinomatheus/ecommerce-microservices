package com.matheushigino.microservices.shoppingapi.repository;

import com.matheushigino.microservices.shoppingapi.dto.ShopReportDTO;
import com.matheushigino.microservices.shoppingapi.model.Shop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ReportRepositoryImpl implements ReportRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo){
        StringBuilder sb = new StringBuilder();
        sb.append("select s ");
        sb.append("from shop s ");
        sb.append("where s.date >= :dataInicio ");

        if(dataFim != null){
            sb.append("and s.date <= :dataFim ");
        }

        if(valorMinimo != null){
            sb.append("and s.total >= :valorMinimo ");
        }

        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio.atTime(0, 0));

        if(dataFim != null){
            query.setParameter("dataFim", dataFim.atTime(23, 59));
        }

        if(valorMinimo != null){
            query.setParameter("valorMinimo", valorMinimo);
        }

        return query.getResultList();
    }

    public ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim){
        StringBuilder sb = new StringBuilder();
        sb.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
        sb.append("from shopping.shop sp ");
        sb.append("where sp.date >= :dataInicio ");
        sb.append("and sp.date <= :dataFim ");

        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio.atTime(0, 0));
        query.setParameter("dataFim", dataFim.atTime(23, 59));

        Object[] result = (Object[]) query.getSingleResult();
        ShopReportDTO shopReportDTO = new ShopReportDTO();

        // Uma coisa importante é que a consulta retorna sempre BigInteger para consultas com a função count, e Double para consultas com as funções sum e avg.
        shopReportDTO.setCount(((Number) result[0]).intValue());
        shopReportDTO.setTotal(result[1] != null ? ((Number) result[1]).doubleValue() : 0.0);
        shopReportDTO.setMean(result[2] != null ? ((Number) result[2]).doubleValue() : 0.0);

        return shopReportDTO;
    }
}
