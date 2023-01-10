package store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import store.bean.PayDTO;

@Repository
public interface PayDAO extends JpaRepository<PayDTO, String> {
	
	@Query("select payDTO from PayDTO payDTO where payDTO.orderNumber=:orderNumber")
	public PayDTO findByPay(@Param("orderNumber") String orderNumber);
	
	
}
