FROM python:3.9-slim AS builder

WORKDIR /app

# Resolved: Use key=value format
ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

RUN apt-get update && apt-get install -y --no-install-recommends gcc

COPY backend/requirements.txt .
RUN pip wheel --no-cache-dir --no-deps --wheel-dir /app/wheels -r requirements.txt


# --- STAGE 2: Final Runtime ---
FROM python:3.9-slim

WORKDIR /app

# Copying from the 'builder' stage
COPY --from=builder /app/wheels /wheels
COPY --from=builder /app/requirements.txt .
RUN pip install --no-cache /wheels/*

COPY backend/ .

EXPOSE 5000

CMD ["python", "app.py"]