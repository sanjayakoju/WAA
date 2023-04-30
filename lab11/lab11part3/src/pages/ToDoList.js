import React from "react";

export const ToDoList = ({dataList, isTodoList, handleTaskMoveFunc}) => {

    const onTaskMove = (event) => {
        handleTaskMoveFunc(event.target.value);
    }

    return (
        <div className="border-default">
            <ul>
                {dataList.map(task => (
                    <li key={task.taskNo}>
                        <span>{task.taskNo} : {task.name}</span>
                        {isTodoList ?
                            <button type="button" value={task.taskNo} onClick={onTaskMove}> &rarr; </button>
                            :
                            <button type="button" value={task.taskNo} onClick={onTaskMove}> &larr; </button>
                        }
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default ToDoList;