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

    private User user;

    public AddUserRemoteApplicationEvent() {
        this.user = null;
    }

    public AddUserRemoteApplicationEvent(Object source, String originService, User user) {
        super(source, originService);
        this.user = user;
    }

    public AddUserRemoteApplicationEvent(Object source, String originService, String destinationService, User user) {
        super(source, originService, destinationService);
        this.user = user;
    }

}
