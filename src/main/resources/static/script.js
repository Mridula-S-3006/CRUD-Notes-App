const API_URL = "http://localhost:8080/api/notes";

const noteForm = document.getElementById("noteForm");
const titleInput = document.getElementById("title");
const contentInput = document.getElementById("content");
const notesList = document.getElementById("notesList");

// Fetch and display notes
async function fetchNotes() {
  const res = await fetch(API_URL);
  const notes = await res.json();
  notesList.innerHTML = "";
  notes.forEach(note => {
    const noteDiv = document.createElement("div");
    noteDiv.className = "note";
    noteDiv.innerHTML = `
      <h3>${note.title}</h3>
      <p>${note.content}</p>
      <div class="note-actions">
        <button onclick="editNote(${note.id}, '${note.title}', '${note.content}')">Edit</button>
        <button class="delete" onclick="deleteNote(${note.id})">Delete</button>
      </div>
    `;
    notesList.appendChild(noteDiv);
  });
}

// Add or update note
noteForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  const title = titleInput.value;
  const content = contentInput.value;

  if (noteForm.dataset.editing) {
    // Update note
    const id = noteForm.dataset.editing;
    await fetch(`${API_URL}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title, content })
    });
    noteForm.dataset.editing = "";
  } else {
    // Create note
    await fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title, content })
    });
  }

  titleInput.value = "";
  contentInput.value = "";
  fetchNotes();
});

// Edit note
function editNote(id, title, content) {
  titleInput.value = title;
  contentInput.value = content;
  noteForm.dataset.editing = id;
}

// Delete note
async function deleteNote(id) {
  await fetch(`${API_URL}/${id}`, { method: "DELETE" });
  fetchNotes();
}

// Initial load
fetchNotes();
