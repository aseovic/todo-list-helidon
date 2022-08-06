# Course materials for Coherence To Do List (Helidon) workshop

## Build Instructions

1. Initialize `npm` to download all Node dependencies needed for the React UI:

    ```bash
    pushd src/main/web/react
    npm install
    popd   
    ```           

2. Build the Project

Run the following from the project root directory

 ```bash
 mvn clean install
 ```

## Running the Example

### Run the server

```bash  
mvn exec:exec
```
   
### Access the Web UI
  
Access via http://localhost:7001/
   
![To Do List - React Client](../../assets/react-client.png)
   
## References

* [Coherence Community Edition](https://github.com/oracle/coherence)
* [Project Helidon](https://helidon.io/)
* [Coherence Community Home Page](https://coherence.community/)



