package pl.tomala.electronicservice.device;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository  extends JpaRepository<Device,Long> {
}
