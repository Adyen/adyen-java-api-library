Vagrant.configure("2") do |config|
  config.vm.box = "jeffnoxon/ubuntu-20.04-arm64"
  config.vm.network "private_network", ip: "192.168.58.30"
  config.vm.provider :parallels do |v|
      v.memory = "4096"
      v.cpus = 2
  end
  config.vm.synced_folder '.', '/home/vagrant/adyen-dotnet-api-library', disabled: false
  config.vm.network :forwarded_port, guest:9876, host: 9876
end