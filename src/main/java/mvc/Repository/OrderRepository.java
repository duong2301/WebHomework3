package mvc.Repository;

import mvc.Entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrdersEntity,Integer> {
}
