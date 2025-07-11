import { Route, Routes } from "react-router-dom";
import "./App.css";
import MainLayout from "./MainLayout";
import ToDoList from "./ToDoList";
import NewTodo from "./NewTodo";

function App() {
  return (
    <>
    <Routes>
      <Route path="/" element={<MainLayout/>}>
        <Route path ="/" element={<ToDoList/>}></Route>
        <Route path="/new-todo" element={<NewTodo></NewTodo>}></Route>
      </Route>
    </Routes>
    </>
  );
  
}
export default App;
