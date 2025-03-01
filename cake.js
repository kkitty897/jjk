const cakeImages = {
    Chocolate: {
        Sprinkles: 'chocolate-sprinkles.jpg', 
        Cherries: 'chocolate-cherries.jpg',   
        Nuts: 'choco-nuts.jpg',           
        'Chocolate Chips': 'choco-chips.jpg' 
    },
    Vanilla: {
        Sprinkles: 'van-sprinkles.jpg',  
        Cherries: 'van-cherries.png',     
        Nuts: 'van-chips.png',              
        'Chocolate Chips': 'van-chips.png' 
    },
    'Red Velvet': {
        Sprinkles: 'red-sprin.png', 
        Cherries: 'red-cherr.jpg',   
        Nuts: 'red-nuts.png',           
        'Chocolate Chips': 'red-chips.png' 
    }
};

// Event listener for form submission
document.getElementById('cakeForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    const cakeType = document.getElementById('cakeType').value; // Get the selected cake type
    const frostingType = document.getElementById('frostingType').value; // Get the selected frosting type
    const toppings = Array.from(document.getElementById('toppings').selectedOptions).map(option => option.value); // Get selected toppings

    // Create a summary of the cake
    let summaryText = `🎂 You have created a ${cakeType} cake with ${frostingType} frosting.`;
    if (toppings.length > 0) {
        summaryText += ` 🍒 Toppings: ${toppings.join(', ')}.`;
    } else {
        summaryText += ` ❌ No toppings selected.`;
    }
    document.getElementById('cakeSummary').innerText = summaryText; // Display the summary

    // Display the cake image
    const cakeImage = document.getElementById('cakeImage');
    cakeImage.innerHTML = ''; // Clear previous images

    if (cakeImages[cakeType]) {
        let imageFound = false; // Track if an image is found

        toppings.forEach(topping => {
            if (cakeImages[cakeType][topping]) {
                const cakeImg = document.createElement('img'); // Create an img element
                cakeImg.src = cakeImages[cakeType][topping]; // Set the src to the corresponding image URL
                cakeImg.alt = `${cakeType} Cake with ${topping}`; // Set the alt text
                cakeImg.classList.add('cake-img'); // Add a CSS class for styling
                cakeImage.appendChild(cakeImg); // Append the image
                imageFound = true; // Mark as found
            }
        });

        // If no toppings were selected, show a default cake image
        if (!imageFound) {
            const defaultCakeImg = document.createElement('img');
            defaultCakeImg.src = `default-${cakeType.toLowerCase()}.jpg`; // Example: default-chocolate.jpg
            defaultCakeImg.alt = `${cakeType} Cake (Default)`;
            defaultCakeImg.classList.add('cake-img');
            cakeImage.appendChild(defaultCakeImg);
        }
    }

    // Show the cake display section
    document.getElementById('cakeDisplay').classList.remove('hidden'); // Remove the hidden class to display the cake
});
