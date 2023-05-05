import React from "react";
import TodoList from "./TodoList";
import TodoForm from "./TodoForm";

export const Todo = () => {
    return (
        <div>
            <TodoList/>
            <TodoForm/>
        </div>
    );
}

export default Todo