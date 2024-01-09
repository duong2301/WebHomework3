package mvc.Repository;

import mvc.Entity.OrderDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetailsEntity,Integer> {
}
