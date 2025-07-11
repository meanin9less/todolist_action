import { Link } from "react-router-dom";



export default function Header() {

  return (
    <>
      <h1>To-Do List</h1>
      <Link to="/">todolist</Link>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;
      <Link to="/new-todo">new-todo</Link>
    </>
  );
}