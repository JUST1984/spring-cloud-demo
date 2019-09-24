package com.just1984.spring.cloud.demo.service.api.bus;

import com.just1984.spring.cloud.demo.service.api.vo.User;
import lombok.Data;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-24 20:53
 */
@Data
public class AddUserRemoteApplicationEvent extends RemoteApplicationEvent {

    public AddUserRemoteApplicationEvent(User user, String originService) {
        super(user, originService);
    }

    public AddUserRemoteApplicationEvent(User user, String originService, String destinationService) {
        super(user, originService, destinationService);
    }

}
