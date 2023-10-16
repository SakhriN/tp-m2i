import React, { useContext } from 'react';
import  TaskContext  from './TaskContext';

function TaskList() {
    const { tasks, toggleTaskStatus, deleteTask } = useContext(TaskContext);
  
    return (
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <span
              style={{
                textDecoration: task.completed ? 'line-through' : 'none',
              }}
            >
              {task.name} - A finir le : {task.deadline}
            </span>
            <button onClick={() => toggleTaskStatus(task.id)}>
              {task.completed ? 'En cours' : 'Terminée'}
            </button>
            <button onClick={() => deleteTask(task.id)}>Supprimer</button>
          </li>
        ))}
      </ul>
    );
  }

  export default TaskList;