fetch('/api/services')
    .then(response => response.json())  // Convert the response to JSON
    .then(data => {
        const tbody = document.querySelector('tbody');
        data.forEach(service => {
            const row = document.createElement('tr'); // Create a table row
            row.innerHTML = `
                <td>${service.id}</td>
                <td>${service.name}</td>
                <td>${service.description}</td>
                <td>${service.status}</td>
            `;
            tbody.appendChild(row); // Append the row to the table body
        });
    })
    .catch(err => console.error('Error fetching services:', err));  // Log any errors
