 ## Kubernetes Kubectl Commands for Minikube
 *`kubectl` commands are applicable for any kubernetes cluster*


 #### Minikube Basics
 | Commands        |  What it does
 |-----------------|------------------------------------
`minikube start`  |               Start Minikube cluster
`minikube stop`  |               Stop Minikube cluster
`minikube delete`|               Delete Minikube cluster
`minikube status`|               Check Minikube status
`minikube dashboard`|            Open Minikube dashboard
`minikube ip   ` |                Get Minikube IP address
`minikube service list`|         List all running services
`minikube addons list`|          List available addons
`minikube addons enable <name>`|   Enable an addon
`minikube addons disable <name>`|  Disable an addon
 

 #### Kubectl Basic Commands
| Commands             |what it does|
|----------------------|-------------------------------------| 
|`kubectl version --short  `|          Get kubectl version|
|`kubectl cluster-info `|              Get cluster information|
| `kubectl get nodes    `   |           List all nodes in the cluster|
|`kubectl get pods -A     `|           List all pods in all namespaces|
|`kubectl get services -A `|           List all services in all namespaces|
|`kubectl get deployments -A`|         List all deployments in all namespaces|
|`kubectl describe pod <pod-name> ` |  Get detailed information about a pod|
|`kubectl logs <pod-name>   ` |         View logs of a specific pod|
|`kubectl exec -it <pod-name> -- /bin/sh `|   Access a pod's shell|


#### Managing Deployments
| Commands                                              | What it does                  | 
|-------------------------------------------------------|--------------------------------|
|`kubectl create deployment <name> --image=<image-name>`|    Create a deployment|
|`kubectl scale deployment <name> --replicas=<number>  `|    Scale deployment|
|`kubectl rollout status deployment <name>   `|              Check rollout status|
|`kubectl rollout undo deployment <name>   `|                Rollback to previous version|
|`kubectl delete deployment <name>  `|                       Delete a deployment|
 

#### Managing Services
| Commands                                              | What it does                  | 
|-------------------------------------------------------|--------------------------------|
|`kubectl expose deployment <name> --type=NodePort --port=<port>`|   Expose deployment as a service|
|`kubectl get svc <name>     `|                                      Get service details|
|`kubectl delete svc <name>   `|                                     Delete a service|
 

#### Managing Configurations
 | Commands                                              | What it does                  | 
|-------------------------------------------------------|--------------------------------|
|`kubectl apply -f <file>.yaml `|    Apply a configuration file|
|`kubectl delete -f <file>.yaml `|   Delete resources from a file|
|`kubectl get configmap  `|          List all ConfigMaps|
|`kubectl get secrets   `|           List all Secrets|
 

#### Namespace Management
 | Commands                                              | What it does                  | 
|-------------------------------------------------------|--------------------------------|
|`kubectl get namespaces      `|        List all namespaces|
|`kubectl create namespace <name> `|    Create a new namespace|
|`kubectl delete namespace <name> `|    Delete a namespace
 

#### Port Forwarding & Logs
| Commands                                              | What it does                  | 
|-------------------------------------------------------|--------------------------------| 
|`kubectl port-forward svc/<service-name> 8080:80`|   Forward port 8080 to service port 80|
|`ubectl logs -f <pod-name>   `|                    Follow logs of a pod|
 

#### Cleanup & Reset
 | Commands                                              | What it does                  | 
|-------------------------------------------------------|--------------------------------|
|`kubectl delete all --all -n <namespace>`|   Delete all resources in a namespace|
|`minikube stop       `|                      Stop Minikube|
|`minikube delete   `|                        Delete Minikube cluster|
 

---

