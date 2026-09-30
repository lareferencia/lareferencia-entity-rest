# LA Referencia Entity REST API

Read-only REST API for searching scholarly entities in Elasticsearch/OpenSearch.

## Current state (verified 2026-09-23)

This module is in **transition**. Most endpoints of `EntitySearchController`
are commented out ("avoid Solr dependency issues"); the only active endpoint is:

- `GET /search/entity/{type}` — paginated entity search over Elasticsearch
  (`{type}` follows the installed entity types, e.g. `publication`, `person`,
  `organization`, `project`).

Swagger UI: `GET /swagger` (Springfox). Server context path: `/api/v2`,
port `8094` (host `8194` in the `docker-dev` isolated instance).

Relationship navigation, semantic identifier resolution and listing by type
(`/lis/{type}`) are present in code but currently disabled. The live entity
indexing pipeline is described in
[`docs/ENTITY_INDEXING_ARCHITECTURE.md`](../docs/ENTITY_INDEXING_ARCHITECTURE.md).

## 📄 License

Licensed under the **GNU Affero General Public License v3.0 (AGPL-3.0)**.  
See [LICENSE.txt](../LICENSE.txt) for complete terms.

## 📧 Support

**Email**: soporte@lareferencia.redclara.net

---

**LA Referencia** - Red Latinoamericana y de España de Ciencia Abierta  
Part of the LA Referencia Platform 5.0.0-rc2
