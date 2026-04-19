# --- STAGE 1: Builder ---
FROM python:3.9-slim as builder

WORKDIR /app

# Prevent Python from writing .pyc files and enable unbuffered logging
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

# Install build dependencies
RUN apt-get update && apt-get install -y --no-install-recommends gcc

# Install dependencies into a temporary directory
COPY backend/requirements.txt .
RUN pip wheel --no-cache-dir --no-deps --wheel-dir /app/wheels -r requirements.txt


# --- STAGE 2: Final Runtime ---
FROM python:3.9-slim

WORKDIR /app

# Copy wheels from builder and install them
COPY --from=builder /app/wheels /wheels
COPY --from=builder /app/requirements.txt .
RUN pip install --no-cache /wheels/*

# Copy the application code
COPY backend/ .

# Expose the port Flask runs on
EXPOSE 5000

# Run the application
CMD ["python", "app.py"]