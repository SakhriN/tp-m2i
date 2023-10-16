import React, { useRef } from 'react';
import  TaskContext  from './TaskContext';

function TaskForm({ addTask }) {
    const taskNameRef = useRef(null);
    const taskDeadlineRef = useRef(null);   
  
    function handleAddTask() {
      const name = taskNameRef.current.value;
      const deadline = taskDeadlineRef.current.value;
      if (name === '') return; // Ne pas ajouter de tâche vide
  
      const newTask = {
        id: Date.now(),
        name,
        deadline,
        completed: false,
      };
  
      addTask(newTask);
  
      // Effacer les champs du formulaire
      taskNameRef.current.value = '';
      taskDeadlineRef.current.value = '';
    }
  
    return (
      <div>
        <input type="text" placeholder="Nom de la tâche" ref={taskNameRef} />
        <input type="date" ref={taskDeadlineRef} />
        <button onClick={handleAddTask}>Ajouter une tâche</button>
      </div>
    );
  }

  export default TaskForm;