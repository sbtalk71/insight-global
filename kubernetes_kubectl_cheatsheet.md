# Kubernetes kubectl Commands Cheat Sheet

## 1. Cluster Information
```sh
kubectl cluster-info 
kubectl version 
kubectl config view 
kubectl get
nodes 
kubectl describe node `<node-name>`{=html}
```
## 2. Namespace Commands
```sh
kubectl get namespaces
kubectl create namespace dev 
kubectl delete
namespace dev 
kubectl config set-context --current --namespace=dev
```
## 3. Pod Commands
```sh
kubectl run nginx --image=nginx
kubectl get pods 
kubectl get pods -o wide 
kubectl describe pod `<pod-name>`
kubectl delete pod `<pod-name>`
kubectl logs `<pod-name>` 
kubectl logs -f `<pod-name>`
kubectl exec -it `<pod-name>` -- /bin/bash
```
## 4. Deployment Commands
```sh
kubectl create deployment myapp --image=nginx 
kubectl get deployments
kubectl describe deployment myapp 
kubectl scale deployment myapp --replicas=5 
kubectl set image deployment/myapp nginx=nginx:latest
kubectl rollout status deployment myapp 
kubectl rollout history deployment myapp 
kubectl rollout undo deployment myapp 
kubectl delete deployment myapp
```

## 5. ReplicaSet Commands
```sh
kubectl get rs 
kubectl describe rs `<replicaset-name>`
kubectl delete rs `<replicaset-name>`
```
## 6. Service Commands

```sh
kubectl get svc 
kubectl expose deployment myapp --type=NodePort --port=80 
kubectl describe svc myapp 
kubectl delete svc myapp
```

## 7. ConfigMap Commands
```sh
kubectl create configmap app-config --from-literal=env=prod 
kubectl get configmap
kubectl describe configmap app-config 
kubectl delete configmap app-config
```
## 8. Secret Commands
```sh
kubectl create secret generic db-secret --from-literal=password=123456
kubectl get secrets 
kubectl describe secret db-secret 
kubectl delete secret db-secret
```
## 9. YAML Deployment

```sh
kubectl apply -f deployment.yaml 
kubectl create -f deployment.yaml
kubectl delete -f deployment.yaml 
kubectl get all -f deployment.yaml
```
## 10. Resource Monitoring
```sh
kubectl top node 
kubectl top pod
```
## 11. Debugging Commands

```sh
kubectl get events 
kubectl describe pod `<pod-name>`
kubectl logs `<pod-name>`
kubectl exec -it `<pod-name>` -- sh
```
## 12. Label Commands

```sh
kubectl label pods mypod env=prod 
kubectl get pods --show-labels 
kubectl get pods -l env=prod

```
## 13. Annotation Commands

```sh
kubectl annotate pod mypod description="test pod"
```
## 14. Port Forwarding
```sh
kubectl port-forward pod/mypod 8080:80
```
## 15. File Copy

```sh
kubectl cp mypod:/tmp/file.txt ./file.txt 
kubectl cp ./file.txt mypod:/tmp/file.txt
```
## 16. Auto Scaling
```sh
kubectl autoscale deployment myapp --cpu-percent=50 --min=1 --max=10
```
## 17. Get All Resources
```sh
kubectl get all
kubectl get all -n kube-system
```
## 18. Delete Resources
```sh
kubectl delete pod `<pod-name>`
kubectl delete deployment `<deployment-name>`
kubectl delete svc `<service-name>`
kubectl delete -f resource.yaml
```
------------------------------------------------------------------------


