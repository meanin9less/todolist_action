
import { useEffect } from "react";
import Header from "./Header";
import { Outlet } from "react-router-dom";
import apiClient from "./api/clientInstance";
import { useDispatch } from "react-redux";
import { ToDo } from "./todoSlice";

export default function MainLayout(){
 
  const dispatch = useDispatch();

  useEffect(()=>{
    const fetchData = async ()=>{
      try{
        const res = await apiClient.get("/todolist");
        dispatch(ToDo(res.data));
      }catch(err){
        console.log(err);
      }
    }
    fetchData();
  },[dispatch])

  return (
    <>
      <Header></Header>     
      <Outlet/> 
    </>
  );
}