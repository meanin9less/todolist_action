import axios from "axios";

const apiClient = axios.create({
    baseURL:"/api",
    timeout:1000,
    headers:{
        "Content-Type":"application/json"
    }
});

apiClient.interceptors.request.use((config)=>{ // config에 요청객체가 들어옴
    config.headers["Custom-header"]="hello";
    console.log("요청", Date.now());
    return config;
},(err)=>{
    return Promise.reject(err);
})
// err의 response.data ==> 서버에서 body넣어서 리턴한거 띄워줌
export default apiClient;