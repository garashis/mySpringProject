export VAULT_ADDR=https://vault-cluster-new.vault.8e15668b-ba4d-4ace-972d-e4e7f75fa1e3.aws.hashicorp.cloud:8200
export VAULT_NAMESPACE=admin
export VAULT_TOKEN=s.gMw3gM0KhEYw0AuzYd4AJ0pB.Q4lxz

vault secrets enable -path=myapp kv
vault kv put myapp/db dbusername='freedbtech_garashisnew' dbpassword='gaurav1@'

vault kv get myapp/db

https://vault-cluster.vault.8e15668b-ba4d-4ace-972d-e4e7f75fa1e3.aws.hashicorp.cloud:8200/v1/myapp/db



### setup value on local https://gitorko.github.io/2020/08/06/Spring-Cloud-Vault/
brew install vault

#### Start the dev server
vault server -dev -log-level=INFO -dev-root-token-id=00000000-0000-0000-0000-000000000000

#### Start the dev server
export VAULT_ADDR=http://localhost:8200
export VAULT_SKIP_VERIFY=true
export VAULT_TOKEN=00000000-0000-0000-0000-000000000000
vault kv put secret/myapp dbusername='freedbtech_garashisnew' dbpassword='gaurav1@'

eval $(minikube docker-env)
mvn clean package -Dmaven.test.skip=true

docker build -t myspringproject:latest .
docker run -p8080:8080 myspringproject:latest

docker tag myspringproject garashis/myspringproject:1.0
docker login -u garashis docker.io
docker push garashis/myspringproject:1.0

minikube start

kubectl run my --image=myspringproject --image-pull-policy=Never
kubectl create deployment myspringproject --image=garashis/myspringproject:1.0

kubectl get po

kubectl describe po myspringproject-5d665b6556-v6wcl 

kubectl expose deployment myspringproject --type=LoadBalancer --port 8080

Getting the service URL when using Minikube
minikube service myspringproject --url

This will give url. Put the url in browser.
http://127.0.0.1:62663/authors
