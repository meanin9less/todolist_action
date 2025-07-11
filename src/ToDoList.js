import { useDispatch, useSelector } from "react-redux";
import { deleteAllTodolist, updateToDo } from "./todoSlice";
import apiClient from "./api/clientInstance";

export default function ToDoList() {
  const todos = useSelector((state) => state.todos.items);
  const dispatch = useDispatch();

  const update = async (e) => {
      try {
        const res = await apiClient.put("/update-todo", { id: Number(e.target.id) });
        dispatch(updateToDo(res.data));
      } catch (err) {
        console.log(err);
      }
    };

  const deleteAll = async (e) => {
      try {
        await apiClient.delete("/delete-todo");
        dispatch(deleteAllTodolist());
      } catch (err) {
        console.log(err);
      }
  };

  
  return (
    <>
      <ul>
        {todos && todos.map(todo => (
          <li key={todo.id} style={todo.status === true ? {textDecoration : "line-through"} : null}>
            {todo.task}
            <button id={todo.id} onClick={update}>완료</button>
          </li>
        ))}
      </ul>
      {todos && <button onClick={deleteAll}>완료 지우기</button>}
    </>
  );
}