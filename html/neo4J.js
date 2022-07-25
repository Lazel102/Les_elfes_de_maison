let saveFile = () => {
    	
  // Get the data from each element on the form.
const name = document.getElementById('01');


  
  // This variable stores all the data.
  let data = 
  '\r Name: ' + name.value + ' \r\n ' ;
  
  // Convert the text to BLOB.
  const textToBLOB = new Blob([data], { type: 'text/plain' });
  const sFileName = 'formData.txt';	   // The file to save the data.

  let newLink = document.createElement("a");
  newLink.download = sFileName;

  if (window.webkitURL != null) {
      newLink.href = window.webkitURL.createObjectURL(textToBLOB);
  }
  else {
      newLink.href = window.URL.createObjectURL(textToBLOB);
      newLink.style.display = "none";
      document.body.appendChild(newLink);
  }

  newLink.click(); 
}
/*
function saveStaticDataToFile() {

  var input = document.getElementById('01').value;

alert(input)
  } 



function addRecipe(){
  (async() => {
    const neo4j = require('neo4j-driver')
    
    const uri = 'neo4j+s://75cf5522.databases.neo4j.io';
    const user = 'neo4j';
    const password = '2THpGtAhXA54_pV2KRgsV_kJEJbuXlZAAd2J6yuxszQ';
    
    const driver = neo4j.driver(uri, neo4j.auth.basic(user, password))
    const session = driver.session()
   
    const person1Name = document.getElementById('01').value
    const person2Name = document.getElementById('02').value
    console.log(person1Name)
    console.log(person2Name)

    try {
      // To learn more about the Cypher syntax, see https://neo4j.com/docs/cypher-manual/current/
      // The Reference Card is also a good resource for keywords https://neo4j.com/docs/cypher-refcard/current/
      const writeQuery = `MERGE (p1:Person { name: $person1Name })
                          MERGE (p2:Person { name: $person2Name })
                          MERGE (p1)-[:KNOWS]->(p2)
                          RETURN p1, p2`
   
      // Write transactions allow the driver to handle retries and transient errors
      const writeResult = await session.writeTransaction(tx =>
        tx.run(writeQuery, { person1Name, person2Name })
      )
      writeResult.records.forEach(record => {
        const person1Node = record.get('p1')
        const person2Node = record.get('p2')
        console.log(
          `Created friendship between: ${person1Node.properties.name}, ${person2Node.properties.name}`
        )
      })
   
      const readQuery = `MATCH (p:Person)
                         WHERE p.name = $personName
                         RETURN p.name AS name`
      const readResult = await session.readTransaction(tx =>
        tx.run(readQuery, { personName: person1Name })
      )
      readResult.records.forEach(record => {
        console.log(`Found person: ${record.get('name')}`)
      })
    } catch (error) {
      console.error('Something went wrong: ', error)
    } finally {
      await session.close()
    }
   
    // Don't forget to close the driver connection when you're finished with it
    await driver.close()
   })()
  };*/