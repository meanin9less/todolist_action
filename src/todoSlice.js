import { createSlice } from "@reduxjs/toolkit";

const todoSlice=createSlice({
    name:"todos",
    initialState:{
        items:[], //{id:.., task:...}        
    },
    reducers:{
        ToDo:(state, action)=>{
            if(action.payload){
                state.items = action.payload;
            }
        },
        addToDo:(state, action)=>{
            state.items.push(action.payload);
        },
        updateToDo:(state, action)=>{
            state.items = state.items.map(t=>t.id===action.payload.id ? t = action.payload : t);
        },
        deleteAllTodolist:(state)=>{
            state.items = state.items.filter(t=>t.status !== true);
        }
    }
});

export const {ToDo, addToDo, updateToDo, deleteAllTodolist}=todoSlice.actions;
export default todoSlice;
