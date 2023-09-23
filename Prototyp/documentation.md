# Documentation

## Todo
- Verify that in "createEvent.html" & "createReciepe.html" the image preview works.
- Verify how multiple registered participants are displayed in "event.html".
- Implement a notification in "home.html" : "You haven't registered in any event yet, you can join or create a new event below". (Done from the side of the backend, might need adaptions from the front end.)
- In "event.html" Implement a link toward a Registered event without the "Join Event" button (Fresh Event # Registered event).
- In "addRecipe.html" and "createEvent.html" CHECK THE PROPER IMPLEMENTATION  of image upload (check push history "Updated IMAGE UPLOAD ??" june 1)
- In "event.html" and "createEvent" implement button to send to "addRecipe.html". (Does not make sense regarding the logic : 1 Person 1 Recipe)
- Add preview of Image when creating an event and recipes are added.
- Set a maximum character number for {event.title}, {recipes}, {numberOfParticipants}, {kitchenAdress} (50).
- verify that e can not be used as number in type="number" inputs.
- Implement Logout

## BUG FIXES
-Fix the image height for class "eventContainer" in "home.html"

## Notes
- In the ressources folder in future updates is a folder with possible future templates.

## Design
- Check consistency on different pages.
- Set proper gaps, margins and spacings.
- Differenciate Fresh Events from Registered Events.
- Rethink colors (add saturation, gradients/sketchy edges...)
- Find new open font.
 
## Expantion Ideas
- Create MySettings.html (user settings).
- Include commentary section for each page (feedback).
- Recipes can later be added to userprofil.
- The users within an event will in the future be able to vote for a date.
- Previous events can later be displayed in each user's profile
- User can later access a calendar with its upcoming events
- Notifications to remind upcoming events and archive previous ones

## Glossar
- **Event**: A batch cooking event
- **Fresh event**: A batch cooking event that is still open in joinEvent.html
- **Registered event**: When a given user is currently enrolled in a specific batch cooking event
- **Locked event**: A batch cooking event that is confirmed and that is nor open nor available open in joinEvent.html

