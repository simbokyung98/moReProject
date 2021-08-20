package spring.domain.material;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    public List<Material> findByMaterialMainCate(String MaterialMainCate);

}
