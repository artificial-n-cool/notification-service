build:
	docker-compose build
	docker-compose up  # -d
clean:
	docker stop notifications-app
	docker stop mongo-db
	docker rm notifications-app
	docker rm mongo-db
	docker rmi notificationsapp_notifications-app