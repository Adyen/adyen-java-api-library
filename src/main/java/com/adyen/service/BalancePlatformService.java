package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.balancePlatform.General;

public class BalancePlatformService extends Service {
    public BalancePlatformService(Client client) {
        super(client);
    }

    public General general = new General(this.getClient());


}
