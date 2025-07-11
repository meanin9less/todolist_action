
import apiClient from "./api/clientInstance";
import { addToDo } from "./todoSlice";
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';



const NewTodo = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const newTodo = (e) => {
        e.preventDefault();
        const text = e.target.todo.value.trim();
        if (text) {
          const add = async () => {
            try {
              const res = await apiClient.post("/new-todo", { task: text });
              dispatch(addToDo(res.data));
            } catch (err) {
              console.log(err);
            }
          }
          add();
          e.target.todo.value = "";
          navigate("/");
        }
      };
  return (
    <div>
        <h2>new todo</h2>
        <form onSubmit={newTodo}>
        <input type="text" name="todo" placeholder="Add a new task"></input>
        <input type="submit" value="Add Todo"></input>
      </form>
    </div>
  )
}

export default NewTodo