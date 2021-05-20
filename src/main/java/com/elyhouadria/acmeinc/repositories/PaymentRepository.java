package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    void deletePaymentById(Integer id);
    Optional<Payment> findPaymentById(Integer id);

	/*int AddPayement(Payment payement);

	void DeletePayement(int payementId);

	void UpdatePayement(Payment payement);

	List<Payment> getAllPayements();*/

}
