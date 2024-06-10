const today = new Date();
const dateElement = document.getElementById("date");

// Get year, month (0-indexed), and day
const year = today.getFullYear();
const month = today.getMonth() + 1; // Add 1 to get actual month (January is 0)
const day = today.getDate();

// Format the date with leading zeros for month and day (optional)
const formattedDate = `${year}-${month.toString().padStart(2, "0")}-${day.toString().padStart(2, "0")}`;

dateElement.textContent = formattedDate;



const searchInput = document.getElementById("search-input");
const locationDisplay = document.getElementById("location-display");

searchInput.addEventListener("keyup", (event) => {
  const searchTerm = event.target.value;
  if (searchTerm.length > 0) {
    locationDisplay.textContent = `Searching for: ${searchTerm}`;
  } else {
    locationDisplay.textContent = "input text";
  }
});